import AmendBalanceForm from "./AmendBalanceForm";
import Modal from "react-modal";
import "../styles/modal.css";

const AmendBalanceModal = ({ isOpen, closeModal, account, action }) => {
  return (
    <>
      <Modal
        isOpen={isOpen}
        onRequestClose={closeModal}
        overlayClassName="react-modal-overlay"
        className="react-modal-content"
        contentLabel="amend-balance"
      >
        <div className="modal-header">
          <h2>Update Account Balance</h2>
        </div>

        <div className="modal-body">
          <AmendBalanceForm 
            closeModal={closeModal} 
            account={account} 
            action={action}
          />
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

export default AmendBalanceModal;
