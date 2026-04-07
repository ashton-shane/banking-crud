import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";

export default function CustomerDetail() {
  const { id } = useParams();
  const [customer, setCustomer] = useState(null);

  useEffect(() => {
    fetch(`/customer/${id}`)
      .then((r) => r.json())
      .then(setCustomer)
      .catch((err) => console.error(err));
  }, [id]);

  if (!customer) return <div className="main">Loading customer...</div>;

  return (
    <main className="main">
      <h2>Customer {customer.id}</h2>
      <pre>{JSON.stringify(customer, null, 2)}</pre>
    </main>
  );
}
