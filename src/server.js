import express from 'express'
import sql from 'sqlite3'
import path from 'path'

const sqlite3 = sql.verbose()

const db = new sqlite3.Database(':memory:')

const app = express()

app.use(express.static('public'))
app.use(express.urlencoded({ extended: false }))
app.set('views', 'views') // <- Set views folder
app.set('view engine', 'pug') // <- Use pug engine

// GET request for the main form
app.get('/', function (req, res) {
    console.log('GET / called')
    res.render('index')
})

// POST request to create the user page
app.post('/add_task', async function (req, res) {
    const userText = req.body.task;
    const courseName = req.body.courseName;
    const startTime = req.body.startTime;
    const endTime = req.body.endTime;
    const location = req.body.location;

    console.log('User entered:', userText)

    const courseData = {
        courseName: courseName,
        startTime: startTime,
        endTime: endTime,
        location: location 
    };

    console.log('Updated course details:', { courseName, startTime, endTime, location });

    // Here, you can store the updated data in the database or send it to the Java server

    try {
        // Send data to the Java server
        const response = await fetch('http://localhost:3000/addCourse', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: new URLSearchParams(courseData)
        });

        const result = await response.text();
        console.log('Java server response:', result);

        // Render the user page with the entered data
        res.render('user', {
            name: userText,
            courseName: courseName,
            startTime: startTime,
            endTime: endTime,
            location: location
        });
    } catch (error) {
        console.error('Error occurred while fetching:', error);
        res.status(500).send('An error occurred');
    }

})

//New page after all info is submitted
app.post('/success', (req, res) => {
    res.render('success', { message: 'Task added successfully!' });
});

// Start server
app.listen(3000, function () {
    console.log('Listening on port 3000...')
})

