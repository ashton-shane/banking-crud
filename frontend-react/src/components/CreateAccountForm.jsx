import { useState, useEffect } from "react";
import axios from "axios";
import "../styles/Form.css";

const CreateAccountForm = ({ closeModal, customerId, customerName }) => {
  // flattened form state (no nested address)
  const [form, setForm] = useState({
    balance: 0.0,
    customerId: customerId,
    customerName: customerName,
    accountType: "",
  });

  // reset to same flattened shape
  useEffect(() => {
    setForm({
      balance: 0.0,
      customerId: customerId ?? "",
      customerName: customerName ?? "",
      accountType: "",
    });
  }, [customerId, customerName]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(form);
    // payload is the flattened form and matches CustomerDTO
    axios
      .post("/api/accounts/create", form)
      .then((res) => {
        console.log("Account created: " + res.data);
        closeModal();
      })
      .catch((err) => {
        console.error(
          "Create account failed: ",
          err.response?.data ?? err.message,
        );
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <p>Customer Name: {customerName}</p>
      <p>Customer Id: {customerId}</p>
      <p>Account Type</p>
      <select
        name="accountType"
        id="accountType"
        value={form.accountType}
        onChange={handleChange}
      >
        <option value="">SELECT ACCOUNT TYPE</option>
        <option value="SAVINGS">SAVINGS</option>
        <option value="CHECKING">CHECKING</option>
      </select>
      <input
        type="text"
        name="balance"
        placeholder="Amount deposited on account creation"
        value={form.balance}
        onChange={handleChange}
      />

      <button type="submit" className="btn btn-add">
        Create
      </button>
    </form>
  );
};

export default CreateAccountForm;
