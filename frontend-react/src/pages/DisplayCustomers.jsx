import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import CustomersList from "../components/CustomersList"

const DisplayCustomers = () => {
  const navigate = useNavigate();
  const [idValue, setIdValue] = useState("");
  const [customers, setCustomers] = useState([]);
  const [selected, setSelected] = useState(null);
  const [showDelete, setShowDelete] = useState(false);
  const [showUpdate, setShowUpdate] = useState(false);
  const [updateName, setUpdateName] = useState("");

  useEffect(() => {
    fetch('http://localhost:8080/customers')
      .then(r => r.json())
      .then(setCustomers)
      .catch(err => console.error(err));
  }, []);

  const goToCustomer = (e) => {
    e && e.preventDefault();
    if (!idValue) return;
    navigate(`/customer/${idValue}`);
  }

  const handleDelete = (row) => {
    setSelected(row);
    setShowDelete(true);
  }

  const confirmDelete = async () => {
  await fetch(`http://localhost:8080/customers/delete/${selected.id}`, { method: 'GET' });
    setCustomers(customers.filter(c => c.id !== selected.id));
    setShowDelete(false);
  }

  const handleUpdate = (row) => {
    setSelected(row);
    setUpdateName(row.name || "");
    setShowUpdate(true);
  }

  const confirmUpdate = async () => {
    // call backend to update name
    await fetch(`/customers/${selected.id}/name`, { method: 'GET' });
    // quick local update
    setCustomers(customers.map(c => c.id === selected.id ? { ...c, name: updateName } : c));
    setShowUpdate(false);
  }

  return (
    <div>
      <form style={{ marginBottom: "1rem" }} onSubmit={goToCustomer}>
        <label style={{ marginRight: "0.5rem" }}>Find Customer by ID:</label>
        <input type="number" value={idValue} onChange={(e) => setIdValue(e.target.value)} placeholder="Enter id" />
        <button type="submit" style={{ marginLeft: "0.5rem" }}>Go</button>
      </form>

      <CustomersList customers={customers} onUpdate={handleUpdate} onDelete={handleDelete} />

      {showDelete && (
        <div className="modal">
          <div className="modal-content">
            <h3>Confirm delete</h3>
            <p>Delete customer {selected.id}?</p>
            <button onClick={confirmDelete}>Yes, delete</button>
            <button onClick={() => setShowDelete(false)}>Cancel</button>
          </div>
        </div>
      )}

      {showUpdate && (
        <div className="modal">
          <div className="modal-content">
            <h3>Update customer {selected.id}</h3>
            <label>Name</label>
            <input value={updateName} onChange={(e) => setUpdateName(e.target.value)} />
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

export default DisplayCustomers