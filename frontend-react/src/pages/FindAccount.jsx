const FindAccount = () => {
    const row = {
        id: 1,
        customerName: "Ash",
        balance: 100.0,
        accountType: "SAVINGS"
    }

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
                            <th scope="col" className="col-actions">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr key={row.id}>
                            <td className="mono">{row.id}</td>
                            <td className="mono">{row.customerName}</td>
                            <td className="mono">{row.balance.toFixed(2)}</td>
                            <td className="mono">{row.accountType}</td>
                            <td className="col-actions">
                                <div className="actions-cell">
                                    <button type="button" className="btn btn-edit">Update</button>
                                    <button type="button" className="btn btn-danger">Delete</button>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </main>
    )
}

export default FindAccount
