import React, { useState, useEffect } from 'react';
import WorkoutPlanCard from './WorkoutPlanCard';

const WorkoutPlansPage = () => {
    const [workoutPlans, setWorkoutPlans] = useState([]);

    useEffect(() => {
        // Fetch workout plans from the server
        // For demonstration purposes, let's assume workoutPlansData is the fetched data
        const workoutPlansData = [
            {
                id: 1,
                name: 'Workout Plan 1',
                description: 'This is the first workout plan',
                routines: 'Routine 1, Routine 2',
                sets: 3,
                reps: 10
            },
            {
                id: 2,
                name: 'Workout Plan 2',
                description: 'This is the second workout plan',
                routines: 'Routine 3, Routine 4',
                sets: 4,
                reps: 12
            },
            // Add more workout plans as needed
        ];

        setWorkoutPlans(workoutPlansData);
    }, []);

    return (
        <div>
            <h1>Workout Plans</h1>
            <div className="card-deck">
                {workoutPlans.map(workoutPlan => (
                    <WorkoutPlanCard key={workoutPlan.id} workoutPlan={workoutPlan} />
                ))}
            </div>
        </div>
    );
};

export default WorkoutPlansPage;
