import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function AccountDetail() {
  const { id } = useParams();
  const [account, setAccount] = useState(null);

  useEffect(() => {
    fetch(`/account/${id}`)
      .then((r) => r.json())
      .then(setAccount)
      .catch((err) => console.error(err));
  }, [id]);

  if (!account) return <div className="main">Loading account...</div>;

  return (
    <main className="main">
      <h2>Account {account.id}</h2>
      <pre>{JSON.stringify(account, null, 2)}</pre>
    </main>
  );
}
