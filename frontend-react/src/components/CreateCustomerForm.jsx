import { useState } from "react";
import axios from "axios";

const CreateCustomerForm = ({ onSuccess }) => {
  const [form, setForm] = useState({
    name: "",
    address: {
      blockNumber: "",
      roadName: "",
      building: "",
      postalCode: "",
    },
  });

  // handle name change
  const handleNameChange = (e) => {
    setForm((prev) => ({
      ...prev,
      name: e.target.value,
    }));
  };

  // handle nested address change
  const handleAddressChange = (e) => {
    const { name, value } = e.target;

    setForm((prev) => ({
      ...prev,
      address: {
        ...prev.address,
        [name]: value,
      },
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post("/api/customers", form)
      .then((res) => {
        console.log("Customer created:", res.data);

        // optional: notify parent
        if (onSuccess) onSuccess(res.data);

        // reset form
        setForm({
          name: "",
          address: {
            blockNumber: "",
            roadName: "",
            building: "",
            postalCode: "",
          },
        });
      })
      .catch((err) => console.error(err));
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>Create Customer</h2>

      {/* Name */}
      <input
        type="text"
        placeholder="Name"
        value={form.name}
        onChange={handleNameChange}
        required
      />

      <h3>Address</h3>

      <input
        type="text"
        name="blockNumber"
        placeholder="Block Number"
        value={form.address.blockNumber}
        onChange={handleAddressChange}
      />

      <input
        type="text"
        name="roadName"
        placeholder="Road Name"
        value={form.address.roadName}
        onChange={handleAddressChange}
      />

      <input
        type="text"
        name="building"
        placeholder="Building"
        value={form.address.building}
        onChange={handleAddressChange}
      />

      <input
        type="text"
        name="postalCode"
        placeholder="Postal Code"
        value={form.address.postalCode}
        onChange={handleAddressChange}
      />

      <button type="submit">Create</button>
    </form>
  );
};

export default CreateCustomerForm;