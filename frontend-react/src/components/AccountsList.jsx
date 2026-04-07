import SearchBar from "./SearchBar";

function AccountsList({ accounts, onUpdate = () => {}, onDelete = () => {} }) {
  return (
    <main className="main">
      <h2>View All Accounts</h2>
      <div className="toolbar">
        <div className="toolbar-left">
          <button type="button" className="btn btn-primary">
            Add New Account
          </button>
          <div className="toolbar-search">
            <SearchBar compact />
          </div>
        </div>
      </div>

      <div className="table-card">
        <table className="accounts-table">
          <thead>
            <tr>
              <th scope="col">Account Id</th>
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
                <td className="mono">{row.balance.toFixed(2)}</td>
                <td className="mono">{row.accountType}</td>
                <td className="col-actions">
                  <div className="actions-cell">
                    <button type="button" className="btn btn-edit" onClick={() => onUpdate(row)}>
                      Update
                    </button>
                    <button type="button" className="btn btn-danger" onClick={() => onDelete(row)}>
                      Delete
                    </button>
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

export default AccountsList;
