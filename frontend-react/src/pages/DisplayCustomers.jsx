import { useState, useEffect } from "react";
import "../styles/inline.css";
import { useNavigate } from "react-router-dom";
import CustomersList from "../components/CustomersList";
import axios from "axios";

const DisplayCustomers = () => {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    axios
      .get("/api/customers")
      .then((res) => setCustomers(res.data))
      .catch((error) => console.error("Error:", error));
  }, []);

  return (
    <div>
      <CustomersList customers={customers} />
    </div>
  );
};

export default DisplayCustomers;
