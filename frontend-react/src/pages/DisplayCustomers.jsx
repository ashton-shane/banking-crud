import { useState, useEffect } from "react";
import "../styles/inline.css";
import { useNavigate } from "react-router-dom";
import CustomersList from "../components/CustomersList";
import axios from "axios";

const DisplayCustomers = () => {
  const [customers, setCustomers] = useState([]);
  const navigate = useNavigate();

  const handleSearch = (id) => {
    navigate(`/customers/${id}`); // 👈 route for accounts
  };

  const handleDelete = (id) => {
    axios
      .delete(`/api/customers/${id}`)
      .then(() => {
        setCustomers(prev => prev.filter(acc => acc.id !== id));
      })
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    axios
      .get("/api/customers")
      .then((res) => setCustomers(res.data))
      .catch((error) => console.error("Error:", error));
  }, []);

  return (
    <div>
      <CustomersList 
        customers={customers}
        handleSearch={handleSearch}
        handleDelete={handleDelete} 
      />
    </div>
  );
};

export default DisplayCustomers;
