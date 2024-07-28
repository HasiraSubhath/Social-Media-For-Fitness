import React from 'react';

const WorkoutPlanCard = ({ workoutPlan }) => {
    return (
        <div className="card">
            <div className="card-body">
                <h5 className="card-title">{workoutPlan.name}</h5>
                <p className="card-text"><strong>Description:</strong> {workoutPlan.description}</p>
                <p className="card-text"><strong>Routines:</strong> {workoutPlan.routines}</p>
                <p className="card-text"><strong>Sets:</strong> {workoutPlan.sets}</p>
                <p className="card-text"><strong>Reps:</strong> {workoutPlan.reps}</p>
            </div>
        </div>
    );
};

export default WorkoutPlanCard;
