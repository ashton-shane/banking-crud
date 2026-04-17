import SearchBar from "./SearchBar";
import { useState } from "react";
import axios from "axios";
import DepositModal from "./DepositModal";

function AccountsList({ accounts, handleDelete, handleSearch, fetchAccounts }) {
  const [selectedAccount, setSelectedAccount] = useState("");

  // === DEPOSIT MODAL STUFF ===
  const [isOpenDep, setIsOpenDep] = useState(false);
  const handleOpenModalDep = () => setIsOpenDep(true);
  const handleCloseModalDep = () => {
    setIsOpenDep(false);
    fetchAccounts();
  };

  // === WITHDRAW MODAL STUFF ===
  const [isOpenWdraw, setIsOpenWdraw] = useState(false);
  const handleOpenModalWdraw = () => setIsOpenWdraw(true);
  const handleCloseModalWdraw = () => {
    setIsOpenWdraw(false);
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
                        handleOpenModalDep();
                      }}
                    >
                      Deposit
                    </button>
                    <button type="button" className="btn btn-edit">
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
      {isOpenDep && selectedAccount && (
        <DepositModal
          isOpen={isOpenDep}
          closeModal={handleCloseModalDep}
          account={selectedAccount}
        ></DepositModal>
      )}
    </main>
  );
}

export default AccountsList;
