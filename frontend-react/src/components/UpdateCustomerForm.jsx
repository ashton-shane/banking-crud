import { useState } from "react";
import axios from "axios";
import "../styles/Form.css";

const UpdateCustomerForm = ({ closeModal, customer }) => {
  // flattened form state (no nested address)
  const [form, setForm] = useState({
    id: customer.id,
    name: customer.name,
    blockNumber: customer.blockNumber,
    roadName: customer.roadName,
    building: customer.building,
    postalCode: customer.postalCode,
    fullAddress: customer.fullAddress,
  });

  // generic change handler for all inputs (name attr must match state keys)
  const handleChange = (e) => {
    const { name, value } = e.target;
    setForm((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post("/api/customers/update", form)
      .then((res) => {
        console.log("Customer updated: " + res.data);
        closeModal();

        // reset to same flattened shape
        setForm({
          id: customer.id,
          name: customer.name,
          blockNumber: customer.blockNumber,
          roadName: customer.roadName,
          building: customer.building,
          postalCode: customer.postalCode,
          fullAddress: customer.fullAddress,
        });
      })
      .catch((err) => {
        console.error(
          "Update customer failed: ",
          err.response?.data ?? err.message,
        );
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h4>Name</h4>

      <input
        type="text"
        name="name"
        placeholder="Name"
        value={form.name}
        onChange={handleChange}
        required
      />

      <h4>Address</h4>

      <input
        type="text"
        name="blockNumber"
        placeholder="Block Number"
        value={form.blockNumber}
        onChange={handleChange}
      />

      <input
        type="text"
        name="roadName"
        placeholder="Road Name"
        value={form.roadName}
        onChange={handleChange}
      />

      <input
        type="text"
        name="building"
        placeholder="Building"
        value={form.building}
        onChange={handleChange}
      />

      <input
        type="text"
        name="postalCode"
        placeholder="Postal Code"
        value={form.postalCode}
        onChange={handleChange}
      />

      <input
        type="text"
        name="fullAddress"
        placeholder="Full Address"
        value={form.fullAddress}
        onChange={handleChange}
      />

      <button type="submit" className="btn btn-add">
        Create
      </button>
    </form>
  );
};

export default UpdateCustomerForm;
