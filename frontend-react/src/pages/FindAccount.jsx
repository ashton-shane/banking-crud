import { useEffect, useState } from "react";
import { useParams } from "react-router-dom"
import axios from "axios";

const FindAccount = () => {
    const { accountId } = useParams();
    const [ accountRow, setAccountRow ] = useState(
        {
            "id": "-",
            "name": "-",
            "balance": 0,
            "accountType": "-"
        }
    )

    useEffect(() => {
        axios.get(`/accounts/"${ accountId }`)
        .then(res => setAccountRow(res.data))
        .catch(error => "Error: " + error);
    }, [accountId]);

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
                        <tr key={accountRow.id}>
                            <td className="mono">{accountRow.id}</td>
                            <td className="mono">{accountRow.customerName}</td>
                            <td className="mono">{accountRow.balance.toFixed(2)}</td>
                            <td className="mono">{accountRow.accountType}</td>
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
