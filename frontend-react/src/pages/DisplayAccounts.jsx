import { useState, useEffect } from "react";
import "../styles/inline.css";
import { useNavigate } from "react-router-dom";
import AccountsList from "../components/AccountsList"

const DisplayAccounts = () => {
    return (
        <div>
            <AccountsList accounts={ accounts } onUpdate={handleUpdate} onDelete={handleDelete} />

        </div>
    )
}

export default DisplayAccounts