import SockJS from "sockjs-client";
import { Client } from "@stomp/stompjs";

let stompClient = null;

export const connectWebSocket = (gameId, onMessageReceived) => {
  const socket = new SockJS("http://localhost:8080/ws-uno");

  stompClient = new Client({
    webSocketFactory: () => socket,

    onConnect: () => {
      console.log("Connected");

      // subscribe to game updates
      stompClient.subscribe(`/topic/game/${gameId}`, (message) => {
        const gameState = JSON.parse(message.body);
        onMessageReceived(gameState);
      });
    },
  });

  stompClient.activate();
};

export const sendMessage = (destination, payload) => {
  if (stompClient && stompClient.connected) {
    stompClient.publish({
      destination,
      body: JSON.stringify(payload),
    });
  }
};

export const disconnectWebSocket = () => {
  if (stompClient) {
    stompClient.deactivate();
  }
};