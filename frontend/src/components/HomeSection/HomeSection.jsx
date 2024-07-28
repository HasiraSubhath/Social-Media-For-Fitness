import { Avatar, Button } from "@mui/material";
import React, { useState } from "react";
import { useFormik } from "formik";
import * as yup from "yup";
import ImageIcon from "@mui/icons-material/Image";
import AttachmentIcon from "@mui/icons-material/Attachment";
import FmdGoodIcon from "@mui/icons-material/FmdGood";
import TagFacesIcon from "@mui/icons-material/TagFaces";
import Card from "./Card";

const validationSchema = yup.object().shape({
  content: yup.string().required("Content is required"),
  image: yup.string().required("Image is required"),
  file: yup.string().required().max(),
});

const HomeSection = () => {
  const [uploadImage, setUploadImage] = useState(null);
  const [selectImage, setSelectImage] = useState("");
  const [uploadFile, setUploadFile] = useState(null);
  const [selectFile, setSelectFile] = useState("");
  const handleSubmit = (values) => {
    console.log(values);
  };
  const formik = useFormik({
    initialValues: {
      content: "",
      image: "",
      file: "",
    },
    onSubmit: handleSubmit,
    validationSchema,
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
    <div className="space-y-5">
      <section>
        <h1 className="py-5 text-xl font-bold opacity-90">Home</h1>
      </section>
      <section className={`pb-10`}>
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
                  <span className="text-red-500">{formik.errors.content}</span>
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
      <section className="">
        {[1, 1, 1, 1, 1].map((item) => (
          <Card />
        ))}
      </section>
    </div>
  );
};

export default HomeSection;
