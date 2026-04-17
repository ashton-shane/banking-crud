import { useState, useEffect } from "react";
import axios from "axios";
import "../styles/Form.css";

const DepositForm = ({ closeModal, account }) => {
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
      .put(`/api/accounts/deposit/${account.id}`, form)
      .then((res) => {
        console.log("Amount deposited successfully ");
        closeModal();
      })
      .catch((err) => {
        console.error(
          "Deposit failed: ",
          err.response?.data ?? err.message,
        );
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <p>Customer Name: {account.customerName}</p>
      <p>Account Id: {account.id}</p>
      <p>Amount to Deposit: </p>
      <input
        type="number"
        name="amount"
        placeholder="Amount to Deposit"
        value={form.amount}
        onChange={handleChange}
      />

      <button type="submit" className="btn btn-add">
        Deposit Money
      </button>
    </form>
  );
};

export default DepositForm;
