import Queue from './Queue.js'

export default function SuperMarket() {
    const queue1 = Queue()
    const queue2 = Queue()
    let market = [
        ['[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','   ','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]']
      , ['[#]','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','[#]']
      , ['[#]','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','[#]']
      , ['[#]','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','   ','[#]']
      , ['[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]','[#]']
    ]
    function generateMarket() {
        addQueue()
        market[queue1.getPosition().y][queue1.getPosition().x] = queue1.getQueue().type
        market[queue2.getPosition().y][queue2.getPosition().x] = queue2.getQueue().type
        return market
    }

    function addQueue () {
        queue1.setQueue(1,'(*)')
        queue2.setQueue(2,'(+)')
        queue1.setPosition(5,2)
        queue2.setPosition(23,2)

    }
    return {
        generateMarket
    }
}
