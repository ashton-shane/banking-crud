import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import axios from "axios";
import DepositModal from "../components/DepositModal";

const FindAccount = ({fetchAccounts}) => {
  const { id } = useParams();
  const navigate = useNavigate();

  const [accountRow, setAccountRow] = useState([
    {
      id: "-",
      name: "-",
      balance: 0,
      accountType: "-",
    },
  ]);

  // === DEPOSIT MODAL STUFF ===
  const [refresh, setRefresh] = useState(false);
  const [isOpenDep, setIsOpenDep] = useState(false);
  const handleOpenModalDep = () => setIsOpenDep(true);
  const handleCloseModalDep = () => {
    setIsOpenDep(false);
    setRefresh((prev) => !prev);
  };

  useEffect(() => {
    axios
      .get(`/api/accounts/${id}`)
      .then((res) => {
        setAccountRow(res.data);
      })
      .catch((error) => "Error: " + error);
  }, [refresh]);

  const handleDelete = (id) => {
    axios
      .delete(`/api/accounts/${id}`)
      .then(() => {
        navigate("/accounts");
      })
      .catch((err) => console.error(err));
  };

  return (
    <main className="main">
      <h2>Account</h2>
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
            <tr key={accountRow.id}>
              <td className="mono">{accountRow.id}</td>
              <td className="mono">{accountRow.customerName}</td>
              <td className="mono">
                {accountRow.balance ? accountRow.balance.toFixed(2) : ""}
              </td>
              <td className="mono">{accountRow.accountType}</td>
              <td className="col-actions">
                <div className="actions-cell">
                    <button
                      type="button"
                      className="btn btn-primary"
                      onClick={() => {
                        setAccountRow(accountRow);
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
                    onClick={() => handleDelete(accountRow.id)}
                  >
                    Delete
                  </button>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      {isOpenDep && accountRow && (
        <DepositModal
          isOpen={isOpenDep}
          closeModal={handleCloseModalDep}
          account={accountRow}
        ></DepositModal>
      )}
    </main>
  );
};

export default FindAccount;
