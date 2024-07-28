import Box from "@mui/material/Box";
import Modal from "@mui/material/Modal";
import { useNavigate } from "react-router-dom";
import { Avatar, Button } from "@mui/material";
import VerifiedIcon from "@mui/icons-material/Verified";
import ImageIcon from "@mui/icons-material/Image";
import AttachmentIcon from "@mui/icons-material/Attachment";
import FmdGoodIcon from "@mui/icons-material/FmdGood";
import TagFacesIcon from "@mui/icons-material/TagFaces";
import { useFormik } from "formik";
import React, { useState } from "react";

const style = {
  position: "absolute",
  top: "50%",
  left: "50%",
  transform: "translate(-50%, -50%)",
  width: 600,
  bgcolor: "background.paper",
  border: "none",
  boxShadow: 24,
  p: 4,
  outline: "none",
  borderRadius: 4,
};

const ReplyModal = ({ handleClose, open }) => {
  const [uploadImage, setUploadImage] = useState(null);
  const [selectImage, setSelectImage] = useState("");
  const [uploadFile, setUploadFile] = useState(null);
  const [selectFile, setSelectFile] = useState("");

  const navigate = useNavigate();
  const handleSubmit = (values) => {};

  const formik = useFormik({
    initialValues: {
      content: "",
      image: "",
      file: "",
      boostId: 5,
    },
    onSubmit: handleSubmit,
  });
  const handleSelectImage = (event) => {
    setUploadImage(true);
    const imgUrl = event.target.files[0];
    formik.setFieldValue("image", imgUrl);
    setSelectImage(imgUrl);
    setUploadImage(false);
  };
  const handleSelectFile = (event) => {
    setUploadFile(true);
    const fileUrl = event.target.files[0];
    formik.setFieldValue("file", fileUrl);
    setSelectFile(fileUrl);
    setUploadFile(false);
  };
  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <div className="flex space-x-5">
            <Avatar
              onClick={() => navigate(`/profile/${5}`)}
              className="cursor-pointer"
              alt="username"
              src="../images/avatar.svg"
            />
            <div className="w-full">
              <div className="flex justify-between items-center">
                <div className="flex cursor-pointer items-center space-x-2">
                  <span className="font-semibold">Sahan Pallage</span>
                  <span className="opacity-70">@sahannn.r . 2m</span>
                  <VerifiedIcon className="text-[#f97316]" />
                </div>
              </div>
              <div className="mt-2">
                <div
                  onClick={() => navigate(`/boost/${3}`)}
                  className="cursor-pointer"
                >
                  <p className="mb-2 p-0">
                    Lorem ipsum dolor, sit amet consectetur adipisicing elit.
                    Sint sit ex quod quas impedit tempore, officia
                    exercitationem deserunt labore error nesciunt amet explicabo
                    deleniti nemo porro. Accusamus, tempora provident.
                    Quibusdam?
                  </p>
                </div>
              </div>
            </div>
          </div>
          <section className={`py-10`}>
            <div className="flex space-x-5">
              <Avatar alt="username" src="../images/avatar.svg" />
              <div className="w-full">
                <form action="" onSubmit={formik.handleSubmit}>
                  <div>
                    <input
                      type="text"
                      name="content"
                      placeholder="Flex Your Thoughts Here..."
                      className={`border-none outline-none text-xl bg-transparent w-full min-w-0`}
                      {...formik.getFieldProps("content")}
                    />
                    {formik.errors.content && formik.touched.content && (
                      <span className="text-red-500">
                        {formik.errors.content}
                      </span>
                    )}
                  </div>
                  {/* <div><img src="" alt="" /></div> */}
                  <div className="flex justify-between items-center mt-5">
                    <div className="flex space-x-5 items-center">
                      <label className="flex items-center space-x-2 rounded-md cursor-pointer">
                        <ImageIcon className="text-[#f97316]" />
                        <input
                          type="file"
                          name="imageFile"
                          className="hidden"
                          onChange={handleSelectImage}
                        />
                      </label>
                      <FmdGoodIcon className="text-[#f97316]" />
                      <TagFacesIcon className="text-[#f97316]" />
                      <label className="flex items-center space-x-2 rounded-md cursor-pointer">
                        <AttachmentIcon className="text-[#f97316]" />
                        <input
                          type="file"
                          name="imageFile"
                          className="hidden"
                          onChange={handleSelectFile}
                        />
                      </label>
                    </div>
                    <div>
                      <Button
                        sx={{
                          width: "100%",
                          borderRadius: "29px",
                          paddingY: "8px",
                          paddingX: "20px",
                          bgcolor: "#f97316",
                          "&:hover": {
                            bgcolor: "#7c2d12",
                          },
                        }}
                        variant="contained"
                        type="submit"
                      >
                        Boost
                      </Button>
                    </div>
                  </div>
                </form>
              </div>
            </div>
          </section>
        </Box>
      </Modal>
    </div>
  );
};

export default ReplyModal;
