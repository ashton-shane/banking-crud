import { useState, useEffect } from "react";
import "../styles/inline.css";
import { useNavigate } from "react-router-dom";
import AccountsList from "../components/AccountsList";
import axios from "axios";

const DisplayAccounts = () => {
  const [accounts, setAccounts] = useState([]);

  useEffect(() => {
    axios
      .get("/api/accounts")
      .then((res) => setAccounts(res.data))
      .catch((error) => console.error("Error:", error));
  }, []);

  return (
    <div>
      <AccountsList accounts={accounts} />
    </div>
  );
};

export default DisplayAccounts;
