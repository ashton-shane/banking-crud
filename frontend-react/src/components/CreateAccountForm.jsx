import { useState } from "react";
import axios from "axios";
import "../styles/Form.css";

const CreateAccountForm = ({ closeModal, customerId, customerName }) => {
  // flattened form state (no nested address)
  const [form, setForm] = useState({
    customerId: customerId,
    customerName: customerName,
    accountType: "",
  });

  const [accountType, setAccountType] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    // payload is the flattened form and matches CustomerDTO
    axios
      .post("/api/accounts/create", form)
      .then((res) => {
        console.log("Account created: " + res.data);
        closeModal();

        // reset to same flattened shape
        setForm({
          customerId: customerId,
          customerName: customerName,
          accountType: accountType,
        });
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
        value={accountType}
        onChange={(e) => setAccountType(e.target.value)}
      >
        <option value="SAVINGS">SAVINGS</option>
        <option value="CHECKING">CHECKING</option>
      </select>

      <button type="submit" className="btn btn-add">
        Create
      </button>
    </form>
  );
};

export default CreateAccountForm;
