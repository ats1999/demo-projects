import Client from "./Client";

function sleep(ms: number) {
  // create and return a Promise
  return new Promise((resolve) => {
    // resolve the Promise after  specified amount of time(ms)
    setTimeout(resolve, ms);
  });
}

async function getData(idx: number) {
  const res = await fetch(
    "https://azure-container-app-test.yellowmeadow-8ca1e717.eastus2.azurecontainerapps.io"
  );
  // The return value is *not* serialized
  // You can return Date, Map, Set, etc.

  console.log("Sleep started: ", idx, new Date().toLocaleTimeString());
  await sleep(1 * 60 * 1000);
  console.log("Sleep Finished: ", idx, new Date().toLocaleTimeString());
  if (!res.ok) {
    // This will activate the closest `error.js` Error Boundary
    throw new Error("Failed to fetch data");
  }

  return res.json();
}

export default async function Home() {
  let data = null;
  for (let i = 0; i < 10; i++) {
    data = await getData(i);
  }
  return (
    <main>
      <Client data={data}></Client>
    </main>
  );
}
