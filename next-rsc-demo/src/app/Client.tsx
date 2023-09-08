export default function Client({ data }: { data: any }) {
  return <div>{JSON.stringify(data[0])}</div>;
}
