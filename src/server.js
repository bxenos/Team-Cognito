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
app.post('/add_task', function (req, res) {
    const userText = req.body.task
    console.log('User entered:', userText)
    
    res.render('user', { name: userText })  // <-- pass data to user.pug
})

// Start server
app.listen(3000, function () {
    console.log('Listening on port 3000...')
})

