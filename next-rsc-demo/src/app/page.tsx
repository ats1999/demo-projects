import Client from "./Client";

function sleep(ms: number) {
  // create and return a Promise
  return new Promise((resolve) => {
    // resolve the Promise after  specified amount of time(ms)
    setTimeout(resolve, ms);
  });
}

async function getData() {
  const res = await fetch(
    "https://azure-container-app-test.yellowmeadow-8ca1e717.eastus2.azurecontainerapps.io"
  );
  // The return value is *not* serialized
  // You can return Date, Map, Set, etc.

  console.log("Sleep started: ", new Date().toLocaleTimeString());
  await sleep(10 * 60 * 1000);
  console.log("Sleep Finished: ", new Date().toLocaleTimeString());
  if (!res.ok) {
    // This will activate the closest `error.js` Error Boundary
    throw new Error("Failed to fetch data");
  }

  return res.json();
}

export default async function Home() {
  const data = await getData();
  return (
    <main>
      <Client data={data}></Client>
    </main>
  );
}
