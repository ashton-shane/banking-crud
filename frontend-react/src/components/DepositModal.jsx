import DepositForm from "./DepositForm";
import Modal from "react-modal";
import "../styles/modal.css";

const DepositModal = ({ isOpen, closeModal, account }) => {
  return (
    <>
      <Modal
        isOpen={isOpen}
        onRequestClose={closeModal}
        overlayClassName="react-modal-overlay"
        className="react-modal-content"
        contentLabel="Deposit Money"
      >
        <div className="modal-header">
          <h2>Update Account Balance</h2>
        </div>

        <div className="modal-body">
          <DepositForm closeModal={closeModal} account={account} />
        </div>

        <div className="modal-footer">
          <button
            type="button"
            className="btn btn-secondary modal-close-btn"
            onClick={closeModal}
          >
            Close
          </button>
        </div>
      </Modal>
    </>
  );
};

export default DepositModal;
