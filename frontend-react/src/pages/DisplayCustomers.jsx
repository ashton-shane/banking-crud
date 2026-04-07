import { useState, useEffect } from "react";
import "../styles/inline.css";
import { useNavigate } from "react-router-dom";
import CustomersList from "../components/CustomersList"

const DisplayCustomers = () => {
  return (
    <div>

      <CustomersList customers={customers} onUpdate={handleUpdate} onDelete={handleDelete} />

    </div>
  )
}

export default DisplayCustomers