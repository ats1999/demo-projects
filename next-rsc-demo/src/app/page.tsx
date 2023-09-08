import Client from "./Client";

async function getData() {
  const res = await fetch(
    "https://azure-container-app-test.yellowmeadow-8ca1e717.eastus2.azurecontainerapps.io"
  );
  // The return value is *not* serialized
  // You can return Date, Map, Set, etc.

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
