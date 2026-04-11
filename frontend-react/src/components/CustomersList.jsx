import CreateCustomerModal from "./CreateCustomerModal";
import CreateAccountModal from "./CreateAccountModal";
import SearchBar from "./SearchBar";
import { useState } from "react";

function CustomersList({
  customers,
  handleSearch,
  handleDelete,
  fetchCustomers,
}) {
  // === CUSTOMER CREATION MODAL STUFF ===
  const [isOpenCM, setIsOpenCM] = useState(false);
  const handleOpenModalCM = () => setIsOpenCM(true);
  const handleCloseModalCM = () => {
    setIsOpenCM(false);
    fetchCustomers();
  };

  // === ACCOUNT CREATION MODAL STUFF ===
  const [selectedCustomer, setSelectedCustomer] = useState(null);
  const [isOpenAM, setIsOpenAM] = useState(false);
  const handleOpenModalAM = () => setIsOpenAM(true);
  const handleCloseModalAM = () => {
    setIsOpenAM(false);
    fetchCustomers();
  };

  return (
    <main className="main">
      <h2>View All Customers</h2>

      <div className="toolbar">
        <div className="toolbar-left">
          <button
            type="button"
            className="btn btn-primary"
            onClick={handleOpenModalCM}
          >
            Add New Customer
          </button>
          <CreateCustomerModal
            isOpen={isOpenCM}
            closeModal={handleCloseModalCM}
          ></CreateCustomerModal>
          <div className="toolbar-search">
            <SearchBar compact onSearch={handleSearch} />
          </div>
        </div>
      </div>

      <div className="table-card">
        <table className="accounts-table">
          <thead>
            <tr>
              <th scope="col">Customer Id</th>
              <th scope="col">Customer Name</th>
              <th scope="col">Account Ids</th>
              <th scope="col" className="col-actions">
                Actions
              </th>
            </tr>
          </thead>
          <tbody>
            {customers.map((row) => (
              <tr key={row.id}>
                <td className="mono">{row.id}</td>
                <td className="mono">{row.name}</td>
                <td className="mono">{row.accountIds.join(", ")}</td>
                <td className="col-actions">
                  <div className="actions-cell">
                    <button type="button" className="btn btn-edit">
                      Update
                    </button>
                    <button
                      type="button"
                      className="btn btn-danger"
                      onClick={() => handleDelete(row.id)}
                    >
                      Delete
                    </button>
                    <button
                      type="button"
                      className="btn btn-primary"
                      onClick={() => {
                        setSelectedCustomer(row);
                        handleOpenModalAM();
                      }}
                    >
                      Create Account
                    </button>
                    {selectedCustomer && (
                      <CreateAccountModal
                        isOpen={isOpenAM}
                        closeModal={handleCloseModalAM}
                        customerId={selectedCustomer.id}
                        customerName={selectedCustomer.name}
                      ></CreateAccountModal>
                    )}
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </main>
  );
}

export default CustomersList;
