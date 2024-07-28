import React from "react";
import { Grid } from "@mui/material";
import Navigation from "../navigation/Navigation";
import HomeSection from "../HomeSection/HomeSection";
import RightPart from "./RightPart";
import { Route, Routes } from "react-router-dom";
import Profile from "../profile/Profile";
import CardDetails from "../CardDetails/CardDetails";
import WorkoutPlanCard from "../WorkoutPlan/WorkoutPlanCard";

const HomePage = () => {
  return (
    <Grid container className="px-5 lg:px-36 justify-between">
      <Grid item xs={12} lg={2.5} className="hidden lg:block w-full relative">
        <Navigation />
      </Grid>
      <Grid item xs={12} lg={6} className="px-5 lg:px-9 w-full relative">
        <Routes>
          {/* <Route path="/" element={<HomeSection />}></Route> */}
          <Route path="/home" element={<HomeSection />}></Route>
          <Route path="/profile/:id" element={<Profile />}></Route>
          <Route path="/boost/:id" element={<CardDetails />}></Route>
            {/*<Route path="/workout" element={<WorkoutPlanCard/>} />*/}

        </Routes>
      </Grid>
      <Grid item xs={12} lg={3} className="hidden lg:block w-full relative">
        <RightPart />
      </Grid>
    </Grid>
  );
};

export default HomePage;
