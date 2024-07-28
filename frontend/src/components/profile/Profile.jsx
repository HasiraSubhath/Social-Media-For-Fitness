import React, { useState } from "react";
import KeyboardBackspaceIcon from "@mui/icons-material/KeyboardBackspace";
import { useNavigate } from "react-router-dom";
import { Avatar, Button } from "@mui/material";
import VerifiedIcon from "@mui/icons-material/Verified";
import BusinessCenterIcon from "@mui/icons-material/BusinessCenter";
import LocationOnIcon from "@mui/icons-material/LocationOn";
import CalendarMonthIcon from "@mui/icons-material/CalendarMonth";
import Box from "@mui/material/Box";
import Tab from "@mui/material/Tab";
import TabContext from "@mui/lab/TabContext";
import TabList from "@mui/lab/TabList";
import TabPanel from "@mui/lab/TabPanel";
import Card from "../HomeSection/Card";
import ProfileModal from "./ProfileModal";

const Profile = () => {
  const [tabValue, setTabValue] = React.useState("1");
  const navigate = useNavigate();
  const [openProfileModal, setOpenProfileModal] = useState(false);
  const handleOpenProfileModal = () => setOpenProfileModal(true);
  const handleClose = () => setOpenProfileModal(false);
  const handleBack = () => navigate(-1);
  const handleFollowUser = () => {};
  const handleChange = (event, newValue) => {
    setTabValue(newValue);
    if (newValue === 4) {
      console.log("Item four clicked");
    } else if (newValue === 1) {
      console.log("Item one clicked");
    }
  };
  return (
    <div>
      <section
        className={`z-50 flex items-center sticky top-0 bg-white bg-opacity-95`}
      >
        <KeyboardBackspaceIcon
          className="cursor-pointer"
          onClick={handleBack}
        />
        <h1 className="text-xl font-bold ml-5 py-5 opacity-90">
          Sahan Pallage
        </h1>
      </section>
      <section>
        <img
          className="w-[100%] h-[15rem] object-cover"
          src="https://cdn.pixabay.com/photo/2023/10/25/19/25/blue-8341156_640.jpg"
          alt=""
        />
      </section>
      <section className="pl-6">
        <div className="flex justify-between items-start mt-5 h-[5rem] relative z-60">
          <Avatar
            className="transform -translate-y-24"
            alt="Sahan Pallage"
            src="https://cdn.pixabay.com/photo/2023/04/04/12/04/horse-7899209_640.jpg"
            sx={{
              width: "10rem",
              height: "10rem",
              border: "4px solid white",
            }}
          />
          {true ? (
            <Button
              onClick={handleOpenProfileModal}
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
              Edit Profile
            </Button>
          ) : (
            <Button
              onClick={handleFollowUser}
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
              {true ? "Follow" : "Unfollow"}
            </Button>
          )}
        </div>
        <div>
          <div className="flex items-center">
            <h1 className="font-bold text-lg">Sahan Pallage</h1>
            {true && <VerifiedIcon className="text-[#f97316]" />}
          </div>
          <h1 className="text-gray-500">@sahannn.r</h1>
        </div>
        <div className="mt-2 space-y-3">
          <p>
            Lorem ipsum dolor sit amet consectetur adipisicing elit. Nisi
            deleniti, exercitationem dolorum ad ea eum, esse nostrum atque vitae
            tempora itaque. Perspiciatis eos nam harum.
          </p>
          <div className="py-1 flex space-x-5">
            <div className="flex items-center text-gray-500">
              <BusinessCenterIcon />
              <p className="ml-2">Software Engineer</p>
            </div>
            <div className="flex items-center text-gray-500">
              <LocationOnIcon />
              <p className="ml-2">Colombo, Sri Lanka</p>
            </div>
            <div className="flex items-center text-gray-500">
              <CalendarMonthIcon />
              <p className="ml-2">Joined Jan 2023</p>
            </div>
          </div>
          <div className="flex items-center space-x-5">
            <div className="flex items-center space-x-1 font-semibold">
              <span>190</span>
              <span className="text-gray-500">Following</span>
            </div>
            <div className="flex items-center space-x-1 font-semibold">
              <span>590</span>
              <span className="text-gray-500">Followers</span>
            </div>
          </div>
        </div>
      </section>
      <section className="py-5">
        <Box sx={{ width: "100%", typography: "body1" }}>
          <TabContext value={tabValue}>
            <Box sx={{ borderBottom: 1, borderColor: "divider" }}>
              <TabList
                onChange={handleChange}
                aria-label="lab API tabs example"
                TabIndicatorProps={{ style: { backgroundColor: "#f97316" } }}
              >
                <Tab label="Boosts" value="1" />
                <Tab label="Replies" value="2" />
                <Tab label="Media" value="3" />
                <Tab label="Likes" value="4" />
              </TabList>
            </Box>
            <TabPanel value="1">
              {[1, 1, 1, 1].map((item) => (
                <Card />
              ))}
            </TabPanel>
            <TabPanel value="2">users replies</TabPanel>
            <TabPanel value="3">Media</TabPanel>
            <TabPanel value="4">Likes</TabPanel>
          </TabContext>
        </Box>
      </section>
      <section>
        <ProfileModal handleClose={handleClose} open={openProfileModal} />
      </section>
    </div>
  );
};

export default Profile;
