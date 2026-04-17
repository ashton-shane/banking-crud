import SearchBar from "./SearchBar";
import { useState } from "react";
import axios from "axios";
import DepositModal from "./AmendBalanceModal";

function AccountsList({ accounts, handleDelete, handleSearch, fetchAccounts }) {
  const [selectedAccount, setSelectedAccount] = useState("");

  // === DEPOSIT / WITHDRAW MODAL STUFF ===
  const [action, setAction] = useState("");
  const [isOpen, setIsOpen] = useState(false);
  const handleOpenModal = () => setIsOpen(true);
  const handleCloseModal = () => {
    setIsOpen(false);
    fetchAccounts();
  };

  return (
    <main className="main">
      <h2>View All Accounts</h2>
      <div className="toolbar">
        <div className="toolbar-left">
          <div className="toolbar-search">
            <SearchBar compact onSearch={handleSearch} />
          </div>
        </div>
      </div>

      <div className="table-card">
        <table className="accounts-table">
          <thead>
            <tr>
              <th scope="col">Account Id</th>
              <th scope="col">Customer Name</th>
              <th scope="col">Account Balance</th>
              <th scope="col">Account Type</th>
              <th scope="col" className="col-actions">
                Actions
              </th>
            </tr>
          </thead>
          <tbody>
            {accounts.map((row) => (
              <tr key={row.id}>
                <td className="mono">{row.id}</td>
                <td className="mono">{row.customerName}</td>
                <td className="mono">
                  {row.balance ? row.balance.toFixed(2) : "-"}
                </td>
                <td className="mono">{row.accountType}</td>
                <td className="col-actions">
                  <div className="actions-cell">
                    <button
                      type="button"
                      className="btn btn-primary"
                      onClick={() => {
                        setSelectedAccount(row);
                        setAction("DEPOSIT");
                        handleOpenModal();
                      }}
                    >
                      Deposit
                    </button>
                    <button
                      type="button"
                      className="btn btn-edit"
                      onClick={() => {
                        setSelectedAccount(row);
                        setAction("WITHDRAW");
                        handleOpenModal();
                      }}
                    >
                      Withdraw
                    </button>
                    <button
                      type="button"
                      className="btn btn-danger"
                      onClick={() => handleDelete(row.id)}
                    >
                      Delete
                    </button>
                  </div>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      {isOpen && selectedAccount && (
        <DepositModal
          isOpen={isOpen}
          closeModal={handleCloseModal}
          account={selectedAccount}
          action={action}
        ></DepositModal>
      )}
    </main>
  );
}

export default AccountsList;
