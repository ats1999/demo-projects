import { useRouter } from "next/router";
import { useEffect } from "react";
import SockJS from "sockjs-client";
import webstomp from "webstomp-client";

export default function Home() {
  const router = useRouter();

  useEffect(() => {
    if (!router.query.name) {
      return;
    }

    const socket = new SockJS("http://localhost:8080/test", {});
    const stompClient = webstomp.over(socket, { debug: true });
    stompClient.connect({}, function (frame) {
      window.stompClient = stompClient;
      console.log("stompClient Connected..");
      stompClient.send(`/app/user/${router.query.uid}`, router.query.name);

      stompClient.subscribe(`/topic/user/${router.query.uid}`, (msg) => {
        console.log(msg);
      });
    });
  }, [router]);

  return <h1>Hello</h1>;
}
