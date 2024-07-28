import * as React from "react";
import Box from "@mui/material/Box";
import Button from "@mui/material/Button";
import Modal from "@mui/material/Modal";
import { useFormik } from "formik";
import IconButton from "@mui/material/IconButton";
import CloseIcon from "@mui/icons-material/Close";
import { Avatar, TextField } from "@mui/material";

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

const ProfileModal = ({ open, handleClose }) => {
  //   const [open, setOpen] = React.useState(false);
  const [uploading, setUploading] = React.useState(false);

  const handleSubmit = (values) => {
    console.log(values);
  };
  const handleImageChange = (event) => {
    setUploading(true);
    const { name } = event.target;
    const file = event.target.files[0];
    formik.setFieldValue(name, file);
    setUploading(false);
  };

  const formik = useFormik({
    initialValues: {
      fullName: "",
      location: "",
      bio: "",
      backgroundImage: "",
      image: "",
    },
    onSubmit: handleSubmit,
  });

  return (
    <div>
      <Modal
        open={open}
        onClose={handleClose}
        aria-labelledby="modal-modal-title"
        aria-describedby="modal-modal-description"
      >
        <Box sx={style}>
          <form onSubmit={formik.handleSubmit}>
            <div className="flex items-center justify-between">
              <div className="flex items-center space-x-3">
                <IconButton onClick={handleClose} aria-label="delete">
                  <CloseIcon />
                </IconButton>
                <p className="">Edit Profile</p>
              </div>
              <Button
                type="submit"
                className="rounded-full"
                variant="contained"
                sx={{
                  borderRadius: "20px",
                  bgcolor: "#f97316",
                  "&:hover": {
                    bgcolor: "#7c2d12",
                  },
                }}
              >
                Save
              </Button>
            </div>
            <div className="hideScrollBar mt-2 overflow-y-scroll overflow-x-hidden h-[80vh]">
              <React.Fragment>
                <div className="w-full">
                  <div className="relative">
                    <img
                      className="w-full h-[12rem] object-cover object-center"
                      src="https://cdn.pixabay.com/photo/2023/10/25/19/25/blue-8341156_640.jpg"
                      alt=""
                    />
                    <input
                      type="file"
                      className="absolute top-0 left-0 w-full h-full opacity-0 cursor-pointer"
                      name="backgroundImage"
                      onChange={handleImageChange}
                    />
                  </div>
                </div>
                <div className="w-full transform -translate-y-20 ml-4 h-[6rem]">
                  <div className="relative">
                    <Avatar
                      sx={{
                        width: "10rem",
                        height: "10rem",
                        border: "4px solid white",
                      }}
                      src="https://cdn.pixabay.com/photo/2023/04/04/12/04/horse-7899209_640.jpg"
                    />
                    <input
                      className="absolute top-0 left-0 w-[10rem] h-full opacity-0 cursor-pointer"
                      onClick={handleImageChange}
                      name="image"
                      type="file"
                    />
                  </div>
                </div>
              </React.Fragment>
              <div className="space-y-3">
                <TextField
                  fullWidth
                  id="fullName"
                  name="fullName"
                  label="Full Name"
                  value={formik.values.fullName}
                  onChange={formik.handleChange}
                  error={
                    formik.touched.fullName && Boolean(formik.errors.fullName)
                  }
                  helperText={formik.touched.fullName && formik.errors.fullName}
                />
                <TextField
                  fullWidth
                  id="location"
                  name="location"
                  label="Location"
                  value={formik.values.location}
                  onChange={formik.handleChange}
                  error={
                    formik.touched.location && Boolean(formik.errors.location)
                  }
                  helperText={formik.touched.location && formik.errors.location}
                />
                <TextField
                  fullWidth
                  multiline
                  rows={4}
                  id="bio"
                  name="bio"
                  label="Bio"
                  value={formik.values.bio}
                  onChange={formik.handleChange}
                  error={formik.touched.bio && Boolean(formik.errors.bio)}
                  helperText={formik.touched.bio && formik.errors.bio}
                />
                <div className="my-3">
                  <p className="text-lg">Birth date . Edit</p>
                  <p className="text-2xl">Feb 19, 2001</p>
                </div>
                <p></p>
              </div>
            </div>
          </form>
        </Box>
      </Modal>
    </div>
  );
};

export default ProfileModal;
