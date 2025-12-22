"use client";

import { useChat } from "@ai-sdk/react";
import { DefaultChatTransport } from "ai";
import { useState, useEffect, useRef } from "react";
import { ChevronLeft } from "lucide-react";
import Link from "next/link";
import { ChatMessage } from "./_components/chat-message";
import { ChatInput } from "./_components/chat-input";

const INITIAL_MESSAGES = [
  {
    id: "system-welcome",
    role: "system" as const,
    parts: [{ type: "text" as const, text: "Seu assistente de agendamentos está online." }],
  },
  {
    id: "assistant-welcome",
    role: "assistant" as const,
    parts: [
      {
        type: "text" as const,
        text: "Olá! Sou o Shark, seu assistente pessoal.\n\nEstou aqui para te auxiliar a agendar seu corte ou barba, encontrar as barbearias disponíveis perto de você e responder às suas dúvidas.",
      },
    ],
  },
];

export default function ChatPage() {
  const [message, setMessage] = useState("");
  const messagesEndRef = useRef<HTMLDivElement>(null);

  const { messages, sendMessage, status, error } = useChat({
    transport: new DefaultChatTransport({ api: "/api/chat" }),
  });

  useEffect(() => {
    messagesEndRef.current?.scrollIntoView({ behavior: "smooth" });
  }, [messages]);

  const handleSubmit = (e: React.FormEvent) => {
    e.preventDefault();
    const text = message.trim();
    if (!text) return;

    sendMessage({ text });
    setMessage("");
  };

  const isLoading = status === "streaming" || status === "submitted";

  return (
    <div className="relative flex h-screen w-full flex-col overflow-hidden rounded-[20px] bg-[var(--background)]">
      <div className="flex w-[390px] items-center justify-between pt-6 pr-5 pb-0 pl-5">
        <Link href="/">
          <ChevronLeft className="size-6 shrink-0" />
        </Link>
        <p className="font-merriweather text-[20px] leading-[1.4] tracking-[-1px] text-nowrap whitespace-pre text-[var(--foreground)] italic">
          BarberPrime
        </p>
        <div className="flex items-center justify-end gap-[15px]" />
      </div>

      {/* Produção: nunca deixe erro “sumir” */}
      {error?.message ? (
        <div className="px-5 pt-3 text-sm text-red-500">
          {error.message}
        </div>
      ) : null}

      <div className="w-full flex-1 overflow-y-auto pb-24 [&::-webkit-scrollbar]:hidden">
        {messages.length === 0
          ? INITIAL_MESSAGES.map((msg) => (
              <ChatMessage key={msg.id} message={msg} />
            ))
          : messages.map((msg, index) => (
              <ChatMessage
                key={msg.id}
                message={msg}
                isStreaming={status === "streaming" && index === messages.length - 1}
              />
            ))}
        <div ref={messagesEndRef} />
      </div>

      <ChatInput
        input={message}
        onChange={(e) => setMessage(e.target.value)}
        onSubmit={handleSubmit}
        isLoading={isLoading}
      />
    </div>
  );
}
