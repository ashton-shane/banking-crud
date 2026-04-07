import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import AccountsList from "../components/AccountsList"

const DisplayAccounts = () => {
    const navigate = useNavigate();
    const [idValue, setIdValue] = useState("");
    const [accounts, setAccounts] = useState([]);
    const [selected, setSelected] = useState(null);
    const [showDelete, setShowDelete] = useState(false);
    const [showUpdate, setShowUpdate] = useState(false);
    const [updateBalance, setUpdateBalance] = useState("");

    useEffect(() => {
        fetch('http://localhost:8080/accounts')
            .then(r => r.json())
            .then(setAccounts)
            .catch(err => console.error(err));
    }, []);

    const goToAccount = (e) => {
        e && e.preventDefault();
        if (!idValue) return;
        navigate(`/account/${idValue}`);
    }

    const handleDelete = async (row) => {
        setSelected(row);
        setShowDelete(true);
    }

    const confirmDelete = async () => {
    await fetch(`http://localhost:8080/accounts/delete/${selected.id}`, { method: 'GET' });
        setAccounts(accounts.filter(a => a.id !== selected.id));
        setShowDelete(false);
    }

    const handleUpdate = (row) => {
        setSelected(row);
        setUpdateBalance(row.balance);
        setShowUpdate(true);
    }

    const confirmUpdate = async () => {
        const payload = { balance: Number(updateBalance) };
    await fetch(`http://localhost:8080/accounts/${selected.id}/update`, { method: 'POST', headers: { 'Content-Type': 'application/json' }, body: JSON.stringify(payload) });
        setAccounts(accounts.map(a => a.id === selected.id ? { ...a, balance: Number(updateBalance) } : a));
        setShowUpdate(false);
    }

    return (
        <div>
            <form style={{ marginBottom: "1rem" }} onSubmit={goToAccount}>
                <label style={{ marginRight: "0.5rem" }}>Find Account by ID:</label>
                <input type="number" value={idValue} onChange={(e) => setIdValue(e.target.value)} placeholder="Enter id" />
                <button type="submit" style={{ marginLeft: "0.5rem" }}>Go</button>
            </form>

            <AccountsList accounts={ accounts } onUpdate={handleUpdate} onDelete={handleDelete} />

            {showDelete && (
                <div className="modal">
                    <div className="modal-content">
                        <h3>Confirm delete</h3>
                        <p>Delete account {selected.id}?</p>
                        <button onClick={confirmDelete}>Yes, delete</button>
                        <button onClick={() => setShowDelete(false)}>Cancel</button>
                    </div>
                </div>
            )}

            {showUpdate && (
                <div className="modal">
                    <div className="modal-content">
                        <h3>Update account {selected.id}</h3>
                        <label>Balance</label>
                        <input type="number" value={updateBalance} onChange={(e) => setUpdateBalance(e.target.value)} />
                        <div style={{ marginTop: '1rem' }}>
                            <button onClick={confirmUpdate}>Save</button>
                            <button onClick={() => setShowUpdate(false)}>Cancel</button>
                        </div>
                    </div>
                </div>
            )}
        </div>
    )
}

export default DisplayAccounts