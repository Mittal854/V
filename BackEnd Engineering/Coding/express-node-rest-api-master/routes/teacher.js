const express = require('express');
const router = express.Router();
const teachers = require('../models/teacher');

router.post('/', async (req, res) => {
    try {
        const data = new teachers({
            name: req.body.name,
            age: req.body.age,
            email: req.body.email,
            phno: req.body.phno,
            gender: req.body.gender,
            password: req.body.password
        });

        await data.save();  // Save the instance using Mongoose

        console.log("Record Inserted Successfully");
        res.status(201).json({ message: 'Record Inserted Successfully' });  // Send a JSON response
    } catch (err) {
        console.error(err);
        res.status(500).json({ error: 'Failed to insert record' });
    }
});

router.get('/', async (req, res) => {
    try {
        const teacher = await teachers.find();
        res.send(teacher);
    } catch (err) {
        res.status(500).send(err);
    }
});

router.get('/:id', async (req, res) => {
    try {
        const teacher = await teachers.findById(req.params.id);
        res.send(teacher);
    } catch (err) {
        res.status(500).send(err);
    }
});

router.put('/update/:_id', async (req, res) => {
    try {
        const data = await teachers.updateOne(
            { _id: req.params._id }, 
            { $set: req.body }
        );
        res.send(data);
    } catch (err) {
        res.status(500).send(err);
    }
});

router.delete('/delete/:_id', async (req, res) => {
    try {
        const data = await teachers.deleteOne({ _id: req.params._id });
        res.send(data);
    } catch (err) {
        res.status(500).send(err);
    }
});

module.exports = router;
