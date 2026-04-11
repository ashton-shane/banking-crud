import CreateAccountForm from "./CreateAccountForm";
import Modal from "react-modal";
import "../styles/modal.css";

const CreateAccountModal = ({ isOpen, closeModal, customerId, customerName }) => {
  return (
    <>
      <Modal
        isOpen={isOpen}
        onRequestClose={closeModal}
        overlayClassName="react-modal-overlay"
        className="react-modal-content"
        contentLabel="Create Account"
      >
        <div className="modal-header">
          <h2>Create Account</h2>
        </div>

        <div className="modal-body">
          <CreateAccountForm
            closeModal={closeModal}
            customerId={customerId}
            customerName={customerName}
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

export default CreateAccountModal;
