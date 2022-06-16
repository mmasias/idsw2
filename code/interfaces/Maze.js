import { interfaceConsole } from './Console.js'

import { setSurfaceDimension, getSurface, type, color, colorCode } from '../Surface.js'

import Item from '../Item.js'
import Obstacle from '../Obstacle.js'
import SuperMarket from '../Supermarket.js'
import Player from '../Player.js'

const dimensionX = 30
const dimensionY = 30
const quantityItems = 25
const quantityObstacle = 250

setSurfaceDimension(dimensionX, dimensionY)
const maze = getSurface()

const getRandomArbitrary = (min, max) => {
    return parseInt(Math.random() * (max - min) + min, 10)
}
const item = Item()
let items = []
let newItem
const obstacle = Obstacle()
let obstacles = []
let newObstacle

const player = Player()
player.setPosition(0, 0)

const superMarket = SuperMarket()
const market = superMarket.generateMarket()

for (let index = 0; index < quantityObstacle; index++) {
    obstacle.setPosition(getRandomArbitrary(0, dimensionY - 1), getRandomArbitrary(0, dimensionX - 1))
    newObstacle = obstacle.getObstacle()
    obstacles.push(JSON.parse(JSON.stringify(newObstacle)))
}

for (let index = 0; index < quantityItems; index++) {
    item.setPosition(getRandomArbitrary(0, dimensionY - 1), getRandomArbitrary(0, dimensionX - 1))
    newItem = item.getItem()
    items.push(JSON.parse(JSON.stringify(newItem)))
}

for (let index = 0; index < market.length; index++) {
    const element = market[index]
    maze.push(element)
}

let obst, it

for (let index = 0; index <= obstacles.length - 1; index++) {
    obst = obstacles[index]
    maze[obst.posicion.y][obst.posicion.x] = obst.type
}
for (let index = 0; index <= items.length - 1; index++) {
    it = items[index]
    maze[it.posicion.y][it.posicion.x] = it.typeItem
}

async function start(maze) {
    console.log('ITEMS')
    console.log('(+) :', player.getItems().filter(item => item ==='(+)').length)
    console.log('(*) :', player.getItems().filter(item => item ==='(*)').length)
    for (const position_y in maze) {
        const rows = maze[position_y]
        for (const position_x in rows) {
            if (position_y - '' === player.getPosition().y && position_x - '' === player.getPosition().x) {
                process.stdout.write(colorCode['red'])
                process.stdout.write(`${player.getAvatar()}`)
            } else {
                if (typeof maze[position_y][position_x] !== 'string') {
                    const column = rows[position_x]
                    process.stdout.write(colorCode[color[column]])
                    process.stdout.write(`${type[column]}`)
                } else {
                    const column = maze[position_y][position_x]
                    process.stdout.write(colorCode[color[column]])
                    process.stdout.write(`${maze[position_y][position_x]}`)
                }
            }
        }
        console.log('')
    }

    console.log('\x1b[33m%s\x1b[0m', 'Boat[b] Walker[n] Horse[h]')
    console.log('\x1b[36m%s\x1b[0m', 'Move: [a] [s] [d] [w]  Exit[q]')

    interfaceConsole.question('> ', async input => {
        if (input.toUpperCase() === 'Q') {
            interfaceConsole.close()
        } else {
            const newMaze = await player.move(input, maze)
            start(newMaze)
        }
    })
}

start(maze)
