import { useState, useEffect } from "react";
import "../styles/inline.css";
import { useNavigate } from "react-router-dom";
import AccountsList from "../components/AccountsList"

const DisplayAccounts = () => {
        const [accounts, setAccounts] = useState([]);

        const getAccounts = () => {
            // 
        }

        const mockAccounts = [
        { id: 1, balance: 5000.0, accountType: 1 },
        { id: 2, balance: 10000.0, interestRate: 2 },
        { id: 3, balance: 15000.0, interestRate: 1 },
        { id: 4, balance: 20000.0, interestRate: 2 },
        { id: 5, balance: 25000.0, interestRate: 1 },
        { id: 6, balance: 30000.0, interestRate: 2 },
        { id: 7, balance: 35000.0, interestRate: 1 },
        { id: 8, balance: 40000.0, interestRate: 2 },
    ];
    return (
        <div>
            <AccountsList accounts={ accounts } />
        </div>
    )
}

export default DisplayAccounts