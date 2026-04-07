import { useState, useEffect } from "react";
import "../styles/inline.css";
import { useNavigate } from "react-router-dom";
import CustomersList from "../components/CustomersList"

const DisplayCustomers = () => {
      const customers = [
      { id: 1, name: "Ash", account_id: 1 },
      { id: 2, name: "Ash", account_id:  2 },
      { id: 3, name: "Ash", account_id:  1 },
      { id: 4, name: "Ash", account_id:  2 },
      { id: 5, name: "Ash", account_id: 1 },
      { id: 6, name: "Ash", account_id: 3},
      { id: 7, name: "Ash", account_id:  1 },
      { id: 8, name: "Ash", account_id:  2 },
    ];

  return (
    <div>

      <CustomersList customers={customers} />

    </div>
  )
}

export default DisplayCustomers