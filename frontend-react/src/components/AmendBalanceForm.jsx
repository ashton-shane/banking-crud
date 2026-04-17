import { useState, useEffect } from "react";
import axios from "axios";
import "../styles/Form.css";

const AmendBalanceForm = ({ closeModal, account, action }) => {
  // flattened form state (no nested address)
  const [form, setForm] = useState({
    amount: 0,
    accountId: account.id,
    customerName: account.customerName,
  });

  // reset to same flattened shape
  useEffect(() => {
    setForm({
      amount: 0.0,
      accountId: account.id ?? "",
      customerName: account.customerName ?? "",
    });
  }, [account.id, account.customerName]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(form);

    axios
      .put(`/api/accounts/${action.toLowerCase()}/${account.id}`, form)
      .then((res) => {
        console.log(`${action} successful`);
        closeModal();
      })
      .catch((err) => {
        console.error(
          `${action} failed`,
          err.response?.data ?? err.message,
        );
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <p>Customer Name: {account.customerName}</p>
      <p>Account Id: {account.id}</p>
      <p>Amount to {action}: </p>
      <input
        type="number"
        name="amount"
        value={form.amount}
        onChange={handleChange}
      />

      <button type="submit" className="btn btn-add">
        Amend Account Balance
      </button>
    </form>
  );
};

export default AmendBalanceForm;
