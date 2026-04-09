import { useState, useEffect } from "react";
import "../styles/inline.css";
import { useNavigate } from "react-router-dom";
import AccountsList from "../components/AccountsList";
import axios from "axios";

const DisplayAccounts = () => {
  const [accounts, setAccounts] = useState([]);
  const navigate = useNavigate();

  const handleSearch = (id) => {
    navigate(`/accounts/${id}`);
  };

  const handleDelete = (id) => {
    axios
      .delete(`/api/accounts/${id}`)
      .then(() => {
        setAccounts(prev => prev.filter(acc => acc.id !== id));
      })
      .catch((err) => console.error(err));
  };

  useEffect(() => {
    axios
      .get("/api/accounts")
      .then((res) => setAccounts(res.data))
      .catch((error) => console.error("Error:", error));
  }, []);

  return (
    <div>
      <AccountsList 
        accounts={accounts}
        handleDelete={handleDelete}
        handleSearch={handleSearch}
       />
    </div>
  );
};

export default DisplayAccounts;
