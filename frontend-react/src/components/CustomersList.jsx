import CreateCustomerModal from "./CreateCustomerModal";
import CreateAccountModal from "./CreateAccountModal";
import UpdateCustomerModal from "./UpdateCustomerModal";
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
    setSelectedCustomer(null);
    fetchCustomers();
  };

  // === ACCOUNT CREATION MODAL STUFF ===
  const [selectedCustomer, setSelectedCustomer] = useState(null);
  const [isOpenAM, setIsOpenAM] = useState(false);
  const handleOpenModalAM = () => setIsOpenAM(true);
  const handleCloseModalAM = () => {
    setIsOpenAM(false);
    setSelectedCustomer(null);
    fetchCustomers();
  };

  // === UPDATE CUSTOMER MODAL STUFF ===
  const [isOpenUC, setIsOpenUC] = useState(false);
  const handleOpenModalUC = () => setIsOpenUC(true);
  const handleCloseModalUC = () => {
    setIsOpenUC(false);
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
                    <button
                      type="button"
                      className="btn btn-edit"
                      onClick={() => {
                        setSelectedCustomer(row);
                        handleOpenModalUC();
                      }}
                    >
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
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      {/* Render modals once (not inside each row) */}
      {isOpenAM && selectedCustomer && (
        <CreateAccountModal
          isOpen={isOpenAM}
          closeModal={handleCloseModalAM}
          customerId={selectedCustomer.id}
          customerName={selectedCustomer.name}
        ></CreateAccountModal>
      )}

      {isOpenUC && selectedCustomer && (
        <UpdateCustomerModal
          isOpen={isOpenUC}
          closeModal={handleCloseModalUC}
          customer={selectedCustomer}
        ></UpdateCustomerModal>
      )}
    </main>
  );
}

export default CustomersList;
