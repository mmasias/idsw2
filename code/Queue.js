import Coordinate from './Coordinate.js'

export default function Queue() {
    const coordinate = Coordinate()
    const types = {
        1: '[*]',
        2: '[+]',
    }
    
    const itemConsumptionTimes = {
        '(*)': 1200,
        '(+)': 1600,
    }
    let type
    let itemConsumptionTime
    function getQueue (){
        return {
            posicion: getPosition(),
            type,
            itemConsumptionTime
        }
    }

    function setPosition (x, y) {
        coordinate.setPosition(x, y)
    }

    function getPosition (){
        return coordinate.getPosition()
    }

    function setQueue (typeItem, time) {
        type = types[typeItem],
        itemConsumptionTime = itemConsumptionTimes[time]
    }

    return {
        getQueue,
        setPosition,
        getPosition,
        setQueue
    }
}
