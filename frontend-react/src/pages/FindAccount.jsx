import FindById from "../components/FindById";

const findAccount = () => {
    const fakeFetchAccount = async (id) => {
        // simulate network latency
        await new Promise((res) => setTimeout(res, 300));
        return { id, balance: 1000 + Number(id) * 10, interestRate: 1.5 };
    };

    return (
        <FindById id={2} onFind={fakeFetchAccount} />
    )
}

export default findAccount