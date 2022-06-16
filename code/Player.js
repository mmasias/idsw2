import Coordinate from './Coordinate.js'

export default function Player(){
    const coordinate = Coordinate()

    let numberOfSteps = 0
    let avatar = '_0_'

    let items = []
    
    const timeItemConsum = {
        '(*)': 1200,
        '(+)': 1600,
    }

    function setPosition (x, y) {
        numberOfSteps = numberOfSteps + 1
        coordinate.setPosition(x, y)
    }
    function getNumberOfSteps () {
         return numberOfSteps
    }

    function getPosition (){
        return coordinate.getPosition()
    }

    function addItem (item) {
        items.push(item)
    }

    function getItems () {
        return items
    }

    function getAvatar () {
        return avatar
    }

    async function removeItem (item) {

       const indexItems = items.filter(it => it === item)
       for (let index = 1; index <= indexItems.length; index++) {
            printItemRemoved(item, index, indexItems.length )
       }
       items = items.filter(it => it !== item)
       return
    }
     
     function printItemRemoved (item, iteration, cant ) {
        setTimeout(() => {
              console.log(`ITEMS REMOVIDOS: ${item}`, iteration,'/', cant);
              return null
          },iteration*timeItemConsum[item])
     }

    async function move(input, maze){
        let option = input.toUpperCase()
        let valueInt
        const positiony = parseInt(getPosition().y)
        const positionx = parseInt(getPosition().x)
        let nextMov = false
        if (option === 'W') {
            valueInt = positiony
            if (valueInt > 0) {
                const result = valueInt - 1
                 if (maze[result][positionx] !== '[#]'){
                    if(maze[result][positionx] === '(+)' || maze[result][positionx] === '(*)'){
                        addItem(maze[result][positionx])
                        maze[result][positionx] = '   '
                    }
                    if (maze[positiony][result] === '[*]'){
                        await removeItem('(*)')
                    }
                    if (maze[positiony][result] === '[+]'){
                        await removeItem('(+)')
                    }
                    setPosition (positionx, result)
                 }
            }
        }
        if (option === 'S') {
            valueInt = positiony
            if (valueInt < maze.length) {
                const result = valueInt + 1
                if(maze[result][positionx] !== '[#]'){
                    if(maze[result][positionx] === '(+)' || maze[result][positionx] === '(*)'){
                        addItem(maze[result][positionx])
                        maze[result][positionx] = '   '
                    }
                    if (maze[positiony][result] === '[*]'){
                        await  removeItem('(*)')
                    }
                    if (maze[positiony][result] === '[+]'){
                        await removeItem('(+)')
                    }
                    setPosition (positionx,result)
                }
            }
        }
        if (option === 'A') {
            valueInt = positionx
            if (valueInt > 0) {
                const result = valueInt - 1
                if(maze[positiony][result] !== '[#]'){
                    if(maze[positiony][result] === '(+)' || maze[positiony][result] === '(*)'){
                        addItem(maze[positiony][result])
                        maze[positiony][result] = '   '
                    }
                    if (maze[positiony][result] === '[*]'){
                        await removeItem('(*)')
                    }
                    if (maze[positiony][result] === '[+]'){
                        await removeItem('(+)')
                    }
                    setPosition (result, positiony)
                }
            }
        }
        if (option === 'D') {
            valueInt = positionx
            if (valueInt < maze[0].length) {
                const result = valueInt + 1
                if(maze[positiony][result] !== '[#]'){
                    if(maze[positiony][result] === '(+)' || maze[positiony][result] === '(*)'){
                        addItem(maze[positiony][result])
                        maze[positiony][result] = '   '
                    }
                    if (maze[positiony][result] === '[*]'){
                        await removeItem('(*)')
                    }
                    if (maze[positiony][result] === '[+]'){
                        await removeItem('(+)')
                    }
                    setPosition (result, positiony)
                } 
            }
        }


        return maze
    }

    return { 
        addItem,
        getPosition,
        setPosition,
        getNumberOfSteps,
        getItems,
        getAvatar,
        move
     }
}
