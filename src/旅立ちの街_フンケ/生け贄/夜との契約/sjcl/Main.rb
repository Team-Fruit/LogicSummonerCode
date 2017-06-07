@size = $stdin.readline.to_i
@magic = $stdin.read.split(?\n).map!(&:split).map! do |line|
    line.map!(&:to_i)
end

def slant(x)
    array = []
    h = @size-1
    @size.times do |i|
        case x
        when 0
            array << @magic[i][i]
        when @size-1
            array << @magic[h][i]
        end
        h -= 1
    end
    return array
end

def sum
    @size.times do |i|
        w = @magic[i]
        return w.inject(:+) unless w.include?(0)
        h = @magic.transpose[i]
        return h.inject(:+) unless h.include?(0)
    end
    ls = slant(0)
    return ls.inject(:+) unless ls.include?(0)
    rs = slant(@size-1) 
    return rs.inject(:+) unless rs.include?(0)
end

sum = sum()
skipped = false
loop do
    b = false
    @magic.length.times do |i|
        @magic[i].length.times do |j|
            if @magic[i][j] == 0
                n = -1
                if @magic[i].count(0) <= 1
                    n = sum - @magic[i].inject(:+)
                else
                    h = @magic.transpose[j]
                    n = sum - h.inject(:+) if h.count(0) <= 1
                end
                if n >= 0
                    @magic[i][j] = n
                    skipped = true unless b
                else
                    b = true
                    skipped = true
                end
            end
        end
    end
    break if skipped
end
@magic.each do |line|
    puts line.join(" ")
end
